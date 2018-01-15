
package net.asdf.core.query.template.freemarker.method;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import net.asdf.core.query.template.freemarker.FreeMarkerViewTool;

@Component
public class Comma implements FreeMarkerViewTool {

	@Override
	public String getName() {
		return "comma";
	}

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {

		boolean truncate = false;

		String number = ((TemplateScalarModel)arguments.get(0)).getAsString();
		if(arguments.size() > 1) {
			truncate = ((TemplateBooleanModel)arguments.get(1)).getAsBoolean();
		}

		DecimalFormat commaFormat;
		String result = null;
		if (number == null) {
		} else if (number.trim().equals("")) {
		} else if (number.trim().equals("&nbsp;")) {
			result = "&nbsp;";
		} else {
			int pos = number.indexOf(".");
			if (pos != -1) {
				if (!truncate) {
					commaFormat = new DecimalFormat("#,##0.00");
					result = commaFormat.format(Float.parseFloat(number.trim()));
				} else {
					commaFormat = new DecimalFormat("#,##0");
					result = commaFormat.format(Long.parseLong(number.trim().substring(0, pos)));
				}
			} else {
				commaFormat = new DecimalFormat("#,##0");
				result = commaFormat.format(Long.parseLong(number.trim()));
			}
		}
		return SimpleScalar.newInstanceOrNull(result);
	}
}
