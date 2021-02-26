package vbsolutions.com.br.DesafioAppus.utils;

import vbsolutions.com.br.DesafioAppus.dto.VendedorDto;
import vbsolutions.com.br.DesafioAppus.entities.VendedorEntity;

public class VendedorMapper {
	public static VendedorDto toDto(VendedorEntity value) {
		VendedorDto result = new VendedorDto();
		result.setId(value.getId());
		
        return result;
    }
}
