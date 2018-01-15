
package net.asdf.core.query.template.freemarker;

import java.util.Map;

public interface DynamicVariableAwareTool {
	public void setDynamicVariableMap(Map<String,Object> dynamicVariableMap);
}