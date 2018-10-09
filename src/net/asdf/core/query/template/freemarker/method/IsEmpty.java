
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
public class IsEmpty implements FreeMarkerQueryTool, FreeMarkerViewTool  {

	private String[] names = new String[] {"isEmpty", "ie"};

	@Override
	public String[] getNames() {
		return names;
	}

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
		@SuppressWarnings("unchecked")
		List<TemplateModel> models = arguments;
		if(arguments.size() == 0) return TemplateBooleanModel.TRUE;
		for(TemplateModel model : models) {
			if(model == null || "EmptyStringAndSequenceAndHash".equals(model.getClass().getSimpleName())) continue;
			String value = getValue(model);
			if(!StringUtils.isEmpty(value) && !"undefined".contentEquals(value)) {
				return TemplateBooleanModel.FALSE;
			}
		}
		return TemplateBooleanModel.TRUE;
	}

}