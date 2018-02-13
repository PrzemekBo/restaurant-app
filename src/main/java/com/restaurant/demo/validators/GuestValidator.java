package com.restaurant.demo.validators;

import com.restaurant.demo.domains.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GuestValidator implements Validator{
    @Autowired
    private GuestService guestService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Guest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Guest guest = (Guest) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (guest.getName().length()<3 || guest.getName().length()>32){
            errors.rejectValue("name", "Size.guestForm.name");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname",   "NotEmpty");
        if (guest.getSurname().length()<2 || guest.getName().length()>32){
            errors.rejectValue("surname", "Size.guestForm.surname");
        }

    }

}
