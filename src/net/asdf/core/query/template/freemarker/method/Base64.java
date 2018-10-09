
package net.asdf.core.query.template.freemarker.method;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.stereotype.Component;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import net.asdf.core.query.template.freemarker.FreeMarkerViewTool;

@Component
public class Base64 implements FreeMarkerViewTool {

	private String[] names = new String[] {"base64"};

	@Override
	public String[] getNames() {
		return names;
	}

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {

		String result = null;
		String string = ((TemplateScalarModel)arguments.get(0)).getAsString();

		try {
			result = net.asdf.core.codec.Base64.encodeToString(string.getBytes("UTF-8"), false);
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return SimpleScalar.newInstanceOrNull(result);
	}
}