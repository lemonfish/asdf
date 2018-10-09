
package net.asdf.core.query.template.freemarker.method;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import net.asdf.core.query.template.freemarker.FreeMarkerViewTool;

@Component
public class UuidForView implements FreeMarkerViewTool{

	private String[] names = new String[] {"uuid"};

	@Override
	public String[] getNames() {
		return names;
	}

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
		return SimpleScalar.newInstanceOrNull(UUID.randomUUID().toString());
	}



}
