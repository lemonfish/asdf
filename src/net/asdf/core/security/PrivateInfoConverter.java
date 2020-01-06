package net.asdf.core.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

public class PrivateInfoConverter implements ConditionalGenericConverter {

	@Autowired(required = false)
	private CipherService cipherService;

	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return targetType.hasAnnotation(PrivateInfo.class);
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return null;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		return cipherService != null ? cipherService.decipher((String) source) : source;
	}

}
