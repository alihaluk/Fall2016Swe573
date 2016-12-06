package tr.edu.boun.healthtracker.model;

import java.util.List;

/**
 * Created by haluks on 06/12/2016.
 */

public class ErrorModel
{
    /**
     *
     * {
     * 	"Error":
     * 		[{
     * 			"Message" : ?,
     * 			"No": ?
     * 		}]
     * }
     *
     */


    private List<tError> Error;

    public List<tError> getError() {
        return Error;
    }

    public class tError
    {
        String Message;
        Integer No;

        public String getMessage() {
            return Message;
        }

        public Integer getNo() {
            return No;
        }

    }
}
