package net.asdf.core.web.util;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.asdf.core.model.annotation.Json;

public class JsonToObjectConverter implements ConditionalGenericConverter {

	@Resource
	private ObjectMapper mapper;

	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return targetType.hasAnnotation(Json.class);
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return null;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		try {
			return mapper.readValue((String)source, targetType.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
