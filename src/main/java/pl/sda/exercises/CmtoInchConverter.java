package pl.sda.exercises;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CmtoInchConverter {
    private boolean isCmToInch;

    public CmtoInchConverter(@Value("${aplication.isCmToInch}") boolean isCmToInch) {
        this.isCmToInch = isCmToInch;
    }

    public double convert(double value) {
        if (isCmToInch) {
            return value * 2.54;
        } else {
            return value / 2.54;
        }
    }
}
