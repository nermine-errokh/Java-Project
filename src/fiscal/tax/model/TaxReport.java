package fiscal.tax.model;
import java.io.Serializable;

public class TaxReport implements Serializable{
    private int FiscalId ;
    private int FiscalYear;
    private double taxationAmount;
    public TaxReport() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int get() {
        return FiscalId;
    }

    public void setFiscalId(int FiscalId) {
        this.FiscalId =FiscalId;
    }

    public int getFiscalYear() {
        return FiscalYear;
    }
   
    public void setFiscalYear(int fiscalYear2) {
        this.FiscalYear = fiscalYear2;
    }
    public  double computeTax(){
        return this.taxationAmount;
    }

}

