package phone.book;

public enum URI {
    GET_ALL_PHONE_DETAILS, GET_PHONE_DETAILS_BY_NUMBER, ADD_PHONE_DETAILS;

    @Override
    public String toString() {
        switch (this) {
            case ADD_PHONE_DETAILS:
                return "/add-phone-number-with-details";
            case GET_ALL_PHONE_DETAILS:
                return "/get-all-phone-numbers-with-details";
            case GET_PHONE_DETAILS_BY_NUMBER:
                return "/get-details-by-phone-number/1";
        }
        return null;
    }

}
