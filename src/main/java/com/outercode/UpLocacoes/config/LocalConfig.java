package com.outercode.UpLocacoes.config;

import com.outercode.UpLocacoes.models.*;
import com.outercode.UpLocacoes.models.enums.StateContract;
import com.outercode.UpLocacoes.models.enums.StateRent;
import com.outercode.UpLocacoes.repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private RentItemRepository rentItemRepository;

    @Autowired
    private ToolRepository toolRepository;



    @PostConstruct
    public void startDB() throws ParseException {

        Client cli1 = new Client(null, "Vladimir Monteiro Souza de Lima", "05039320-99", new HashSet<>(), new HashSet<>(), new HashSet<>(),
                new HashSet<>());
        Phone ph1 = new Phone(null, "55032300", cli1);
        cli1.getPhones().add(ph1);

        State st1 = new State(null, "RS", new ArrayList<>());
        City ci1 = new City(null, "Esteio", st1);

        st1.getCities().add(ci1);

        Address ad1 = new Address(null, "Dom Pedro", "230 fundos", "sem saida", "12332-330", "centro", ci1, Set.of(cli1));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Rent re1 = new Rent(null, 3000.00, sdf.parse("12/01/2024 10:00"), sdf.parse("12/01/2024 10:00"), StateRent.RENTED.getCode(), cli1, null
        , new HashSet<>());
        Contract co1 = new Contract(null, StateContract.PAID.getCode(), cli1, re1);

        Tool to1 = new Tool(null, "Betoneira p", 13, 100, 200, 300);
        Tool to2 = new Tool(null, "Rompedor", 3, 100, 400, 600);

        RentItem ren1 = new RentItem(300, 1, re1,to1);
        RentItem ren2 = new RentItem(400, 2, re1,to2);

        re1.setContract(co1);

        cli1.getRents().add(re1);
        cli1.getAddresses().add(ad1);






        clientRepository.save(cli1);
        phoneRepository.save(ph1);



        stateRepository.save(st1);
        cityRepository.save(ci1);
        addressRepository.save(ad1);
        rentRepository.save(re1);
        contractRepository.save(co1);
        toolRepository.saveAll(Arrays.asList(to1, to2));
        rentItemRepository.saveAll(Arrays.asList(ren1, ren2));





    }
}
