package at.nacs.streetbasketball;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ConfigurationProperties("sport")
public class BasketballTeamLoader {
    private List<BasketballTeam> teams;
}

