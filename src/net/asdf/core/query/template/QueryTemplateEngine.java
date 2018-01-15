

package net.asdf.core.query.template;

public interface QueryTemplateEngine {

	void init();

	TemplateResult eval(String sql);

	TemplateResult eval(String sql, Object param);

	TemplateResult eval(String sql, Object param, boolean getKey);

}
