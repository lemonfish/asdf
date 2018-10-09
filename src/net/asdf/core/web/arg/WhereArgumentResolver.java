package net.asdf.core.web.arg;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import net.asdf.core.web.arg.annotation.Where;

public class WhereArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String JSONDOC_ATTRIBUTE_NAME = "PP_JSONDOC";

    private Configuration defaultConfiguration;

    public WhereArgumentResolver() {
        defaultConfiguration = Configuration.builder()
                .jsonProvider(new JacksonJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .options(Option.DEFAULT_PATH_LEAF_TO_NULL)
                .build();

    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Where.class);
    }

    /**
     * request body에 json data가 있다고 간주함. 최초 request에서 raw data를 추출 후 객체로 파싱하고, request
     * scope에 해당 데이터를 저장해두고 이후의 요청에서 재활용 한다.
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        DocumentContext doc = (DocumentContext) webRequest.getAttribute(JSONDOC_ATTRIBUTE_NAME,
                RequestAttributes.SCOPE_REQUEST);
        if (doc == null) {
            HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
            doc = JsonPath.parse(servletRequest.getInputStream(), defaultConfiguration);
            webRequest.setAttribute(JSONDOC_ATTRIBUTE_NAME, doc, RequestAttributes.SCOPE_REQUEST);
        }

        String path = parameter.getParameterAnnotation(Where.class).value();
        path = "$".equals(path) ? path : "$." + path;

        return doc.read(path, parameter.getParameterType());
    }

}
