package tr.edu.boun.healthtracker.model;

import tr.edu.boun.healthtracker.model.inner.FoodObject;

/**
 * Created by haluks on 06/12/2016.
 */

public class FoodReportModel
{
    /*
    {
    "report": {
        "food": {
            "ds": "Standard Reference",
            "name": "Cheese, cheddar",
            "ndbno": "01009",
            "nutrients": [
                {
                    "group": "Proximates",
                    "measures": [
                        {
                            "eqv": 132.0,
                            "label": "cup, diced",
                            "qty": 1.0,
                            "value": "48.87"
                        },
                        {
                            "eqv": 244.0,
                            "label": "cup, melted",
                            "qty": 1.0,
                            "value": "90.33"
                        },
                        {
                            "eqv": 113.0,
                            "label": "cup, shredded",
                            "qty": 1.0,
                            "value": "41.83"
                        },
                        {
                            "eqv": 28.35,
                            "label": "oz",
                            "qty": 1.0,
                            "value": "10.50"
                        },
                        {
                            "eqv": 17.0,
                            "label": "cubic inch",
                            "qty": 1.0,
                            "value": "6.29"
                        },
                        {
                            "eqv": 28.0,
                            "label": "slice (1 oz)",
                            "qty": 1.0,
                            "value": "10.37"
                        }
                    ],
                    "name": "Water",
                    "nutrient_id": "255",
                    "unit": "g",
                    "value": "37.02"
                }
            ]
        },
        "footnotes": [],
        "sr": "28",
        "type": "Basic"
    }
}
     */

    private ReportObject report;

    public ReportObject getReport()
    {
        return report;
    }

    public class ReportObject
    {
        String type;
        String sr;
        FoodObject food;

        public FoodObject getFood()
        {
            return food;
        }

        public String getSr()
        {
            return sr;
        }

        public String getType()
        {
            return type;
        }
    }
}
