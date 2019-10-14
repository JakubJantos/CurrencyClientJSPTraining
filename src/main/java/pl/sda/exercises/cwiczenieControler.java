package pl.sda.exercises;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cwiczenieControler {

    public myserv sv;

    CmtoInchConverter converter;

    public cwiczenieControler(myserv sv, CmtoInchConverter converter) {
        this.sv = sv;
        this.converter = converter;
    }

    @GetMapping("/cos")
    public String coś() {
        return sv.wyp();
    }

    @GetMapping("/convert")
    public double prinyHello(@RequestParam double cm){
        return converter.convert(cm);
    }

}
