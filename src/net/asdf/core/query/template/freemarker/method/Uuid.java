

package net.asdf.core.query.template.freemarker.method;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import net.asdf.core.query.template.freemarker.DynamicVariableAwareTool;
import net.asdf.core.query.template.freemarker.FreeMarkerQueryTool;

@Component
public class Uuid implements FreeMarkerQueryTool, DynamicVariableAwareTool{

	private ThreadLocal<Map<String, Object>> dynamicVariableMap = new ThreadLocal<Map<String,Object>>();

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {

		String variableName = ((TemplateScalarModel)arguments.get(0)).getAsString();

		Map<String,Object> m = dynamicVariableMap.get();
		if(!m.containsKey(variableName)) {
			m.put(variableName, UUID.randomUUID().toString());
		}
		return SimpleScalar.newInstanceOrNull(":" + variableName);
	}

	@Override
	public void setDynamicVariableMap(Map<String, Object> dynamicVariableMap) {
		this.dynamicVariableMap.set(dynamicVariableMap);
	}

	private String[] names = new String[] {"uuid"};

	@Override
	public String[] getNames() {
		return names;
	}

}