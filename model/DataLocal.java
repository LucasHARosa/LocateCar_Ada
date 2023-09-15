package model;


import java.time.LocalDateTime;

public class DataLocal {
    private LocalDateTime dataHora;
    private String Local;

    public DataLocal(LocalDateTime dataHora, String Local) {
        this.dataHora = dataHora;
        this.Local = Local;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }
}
