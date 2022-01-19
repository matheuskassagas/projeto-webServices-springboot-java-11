package springWeb.repositoryJPA.entity.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1, "WAITING_PAYMENT"),
    PAID(2, "PAID"),
    SHIPPED(3, "SHIPPED"),
    DELIVERED(4, "DELIVERED"),
    CANCELED(5, "CANCELED");

    private int code;
    private String descricao;

    private OrderStatus(int code, String descricao){
        this.code = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public String getDescricao() {
        return descricao;
    }

    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new IllegalArgumentException("Invalid OrderStatus code");
    }
}
