package com.ej.sensitive.enums;

public enum SensitiveType {

    NAME() {
        private static final String REGEX_1 = "^([\\u4e00-\\u9fa5_\\w]{1})[\\u4e00-\\u9fa5_\\w]*$";
        private static final String REPLACEMENT_1 = "$1*";
        private static final String REGEX_2 = "^([\\u4e00-\\u9fa5_\\w]{1})[\\u4e00-\\u9fa5_\\w_\\s]*([\\u4e00-\\u9fa5_\\w]{1})$";
        private static final String REPLACEMENT_2 = "$1*$2";
        private static final String START = "*";
        public String convert(String oldValue) {
            int length = oldValue.length();
            String newValue = null;
            if (length == 1) {
                newValue = START;
            } else if (length == 2) {
                newValue = oldValue.replaceAll(REGEX_1, REPLACEMENT_1);
            }else{
                newValue = oldValue.replaceAll(REGEX_2, REPLACEMENT_2);
            }
            return newValue;
        }
    }, BANKCARD() {
        private static final String REGEX_1 = "^(\\d{4})\\d*(\\d{4})$";
        private static final String REPLACEMENT_1 = "$1****$2";
        public String convert(String oldValue) {
            return oldValue.replaceAll(REGEX_1, REPLACEMENT_1);
        }
    }, IDCARD() {
        private static final String REGEX_1 = "^(\\d{4})\\d{8,10}(\\d{4}|(\\d{3}(X|x)))$";
        private static final String REPLACEMENT_1 = "$1****$2";
        public String convert(String oldValue) {
            return oldValue.replaceAll(REGEX_1, REPLACEMENT_1);
        }
    }, PHONE() {
        private static final String REGEX_1 = "^(\\d{3})\\d*(\\d{3})$";
        private static final String REPLACEMENT_1 = "$1****$2";
        public String convert(String oldValue) {
            return oldValue.replaceAll(REGEX_1, REPLACEMENT_1);
        }
    }, GENERAL() {
        private static final String START = "*";
        public String convert(String oldValue) {
            return START;
        }
    };

    public abstract String convert(String oldValue);
}
