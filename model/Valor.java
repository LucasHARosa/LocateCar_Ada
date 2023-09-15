package model;

public class Valor {

    private double valorBruto;
    private double valorDesconto;
    private double valorTotal;

    public Valor(double valorBruto, double valorDesconto, double valorTotal) {
        this.valorBruto = valorBruto;
        this.valorDesconto = valorDesconto;
        this.valorTotal = valorTotal;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
