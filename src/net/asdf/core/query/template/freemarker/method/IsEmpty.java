
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

	@Override
	public String getName() {
		return "isEmpty";
	}

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
		@SuppressWarnings("unchecked")
		List<TemplateModel> models = arguments;
		if(arguments.size() == 0) return TemplateBooleanModel.TRUE;
		for(TemplateModel model : models) {
			if(model == null) continue;
			String value = getValue(model);
			if(!StringUtils.isEmpty(value) && !"undefined".contentEquals(value)) {
				return TemplateBooleanModel.FALSE;
			}
		}
		return TemplateBooleanModel.TRUE;
	}

}