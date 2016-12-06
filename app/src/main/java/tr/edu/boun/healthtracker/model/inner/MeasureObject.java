package tr.edu.boun.healthtracker.model.inner;

/**
 * Created by haluks on 06/12/2016.
 */

public class MeasureObject
{
    /*
                        {
                            "eqv": 28.35,
                            "label": "oz",
                            "qty": 1.0,
                            "value": "10.50"
                        },
    */

    Double eqv;
    String label;
    Double qty;
    String value;

    public Double getEqv()
    {
        return eqv;
    }

    public String getLabel()
    {
        return label;
    }

    public Double getQty()
    {
        return qty;
    }

    public String getValue()
    {
        return value;
    }
}
