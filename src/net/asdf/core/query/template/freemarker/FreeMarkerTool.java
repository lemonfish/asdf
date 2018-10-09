

package net.asdf.core.query.template.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;

public interface FreeMarkerTool extends TemplateMethodModelEx {

	public String[] getNames();

	default String getValue(TemplateModel model	) {
		return model.toString();
	}
}