package vn.vnpay.persistenjpa.dto;

public interface   ResponseCode {
    String SUCCESS = "00";
    String FAIL = "01";
    String INSERT_ERROR = "02";
    String UPDATE_ERROR = "03";
    String BLOCK_ERROR = "04";
    String UNLOCK_ERROR = "05";
}
