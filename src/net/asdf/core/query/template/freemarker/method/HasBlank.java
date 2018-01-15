


package net.asdf.core.query.template.freemarker.method;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import net.asdf.core.query.template.freemarker.FreeMarkerQueryTool;
import net.asdf.core.query.template.freemarker.FreeMarkerViewTool;

@Component
public class HasBlank implements FreeMarkerQueryTool, FreeMarkerViewTool  {

	@Override
	public String getName() {
		return "hasBlank";
	}

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
		@SuppressWarnings("unchecked")
		List<TemplateModel> models = arguments;
		if(arguments.size() == 0) return TemplateBooleanModel.TRUE;
		for(TemplateModel model : models) {
			if(model == null) return TemplateBooleanModel.TRUE;
			String value = getValue(model);
			if(StringUtils.isBlank(value) || "undefined".contentEquals(value)) {
				return TemplateBooleanModel.TRUE;
			}
		}
		return TemplateBooleanModel.FALSE;
	}

}