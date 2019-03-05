package at.nacs.ex4theenglishgentleman;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Scope("prototype")
@Component
@Data
public class EnglishGentleman {
    private  final Monocle monocle;
    private final Lighter lighter;
    private boolean read;
    private boolean smoke;


    public boolean hadAGoodDay() {
        return read&& smoke;
    }

    public void smoke(Cigar cigar) throws CigarWasNotLitException {
        lighter.light(cigar);
        cigar.smoke();
        smoke =true;

    }

    public void read(Newspaper newspaper) {
        monocle.read(newspaper);
        read=true;

    }
}
