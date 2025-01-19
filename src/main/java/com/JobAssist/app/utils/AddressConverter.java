package com.JobAssist.app.utils;


import com.JobAssist.app.dto.AddressDTO;
import com.JobAssist.app.entities.Address;
import com.JobAssist.app.entities.UserProfile;

public class AddressConverter {

    public static AddressDTO toDTO(Address address) {
        if (address == null) return null;

        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPostalCode(address.getPostalCode());
        dto.setCountry(address.getCountry());

        // Extracting userId instead of full UserProfile to avoid circular reference
        UserProfile user = address.getUser();
        if (user != null) {
            dto.setUserId(user.getId());
        }

        return dto;
    }

    public static Address toEntity(AddressDTO dto) {
        if (dto == null) return null;

        Address address = new Address();
        address.setId(dto.getId());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());
        address.setCountry(dto.getCountry());

        // UserProfile mapping will need additional logic if necessary
        if (dto.getUserId() != null) {
            UserProfile user = new UserProfile();
            user.setId(dto.getUserId());
            address.setUser(user);
        }

        return address;
    }
}

