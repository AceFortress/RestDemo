package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DbInitializer {
    @Autowired
    private CampaignRepo campaignRepo;

    private static final String words = "Freya ableptically horrifying vouchsafe multifurcate mckuen adventist cushy erne uncrafty intemperately unrepair zoroastrianism anniversary. Monopodic clause hexametric kerenski alevin undercourtier stalemate subclausal juvenileness dravidian legitimatized centrosymmetric renï¿¥ï¾½ alexandrian. Reactively labiovelar hebetating integrating vidar bursary hexylresorcinol blurry handsomeish catachrestic calabazilla touchiest burglarise serflike. Paperboy gynophoric countrywoman clave nonsymphonious unpromiscuous lonesomely hemorrhage lyrated relievable gluttony sapiently reshift piceous. Nonspirited appleton pupa plashiest softwood nonchurched outpreach wrestler presuggestion unmitigatedly aspired toxaemic consulate aril";

    @PostConstruct
    public void init() {
        Random generator = new Random();
        Arrays.asList(words.split(" ")).forEach(word -> {
            Campaign campaign = new Campaign();
            campaign.setName(word);
            campaign.setTags(Stream.of(word + "tag 1", "tag 2").collect(Collectors.toList()));
            campaign.setBidAmount((long) generator.nextInt(1000));
            campaign.setRadius((long) generator.nextInt(1000));
            campaign.setTown(word + "Town");
            campaign.setCampaignFund((long) generator.nextInt(1000));
            campaignRepo.save(campaign);
        });
    }
}
