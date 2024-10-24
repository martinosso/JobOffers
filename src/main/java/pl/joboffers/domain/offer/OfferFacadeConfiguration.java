package pl.joboffers.domain.offer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class OfferFacadeConfiguration {

    @Bean
    OfferFacade offerFacade(OfferFetchable offerFetchable){
        OfferRepository offerRepository = new OfferRepository() {
            @Override
            public List<Offer> findAll() {
                return null;
            }

            @Override
            public boolean existsByOfferUrl(String offerUrl) {
                return false;
            }

            @Override
            public List<Offer> saveAll(List<Offer> offers) {
                return null;
            }

            @Override
            public Optional<Offer> findById(String id) {
                return Optional.empty();
            }

            @Override
            public Offer save(Offer offer) {
                return null;
            }
        };
        OfferService offerService = new OfferService(offerFetchable, offerRepository);
        return new OfferFacade(offerRepository, offerService);
    }
}
