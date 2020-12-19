package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.entertainment.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntertainmentServiceImpl implements EntertainmentService {

    private Map<Integer, Entertainment> entertainmentMap  = new HashMap<>();

    public EntertainmentServiceImpl(){
        initializeTestEntertainment();
    }

    @Override
    public Entertainment get(Integer id){
        return entertainmentMap.get(id);
    }

    @Override
    public List<Entertainment> list(){
        return new ArrayList<>(entertainmentMap.values());
    }

    @Override
    public void delete(Integer id) {
        entertainmentMap.remove(id);
    }

    @Override
    public void add(Entertainment entertainment){

        if (entertainment.getId() == null) {
            entertainment.setId(getNextId());
        }

        entertainmentMap.put(entertainment.getId(), entertainment);
    }

    @Override
    public List<Entertainment> listByType(EntertainmentType entertainmentType) {

        List<Entertainment> newList = new ArrayList<>();
        List<Entertainment> mapList = list();

        for (Entertainment entertainment: mapList) {
            if(entertainment.getType()==entertainmentType){
                newList.add(entertainment);
            }
        }

        return newList;
    }

    private Integer getNextId() {
        return entertainmentMap.isEmpty() ? 1 : Collections.max(entertainmentMap.keySet()) + 1;
    }

    private void initializeTestEntertainment(){
        Entertainment loco = new Restaurant();
        loco.setName("Loco");
        loco.setAvgPrice(160);
        loco.setEmail("loco@loco.pt");
        loco.setPhone("213951861");
        loco.setWorkingHours("19h - 23h");
        loco.setClosed("Sunday - Monday");
        add(loco);

        Entertainment pastel = new Restaurant();
        pastel.setName("Casa Portuguesa Pastel Bacalhau");
        pastel.setAvgPrice(15);
        pastel.setEmail("geral@pasteisdebacalhau.com");
        pastel.setPhone("916486888");
        pastel.setWorkingHours("10h - 22h");
        pastel.setClosed("Always Open");
        add(pastel);

        Entertainment maneiras = new Restaurant();
        maneiras.setName("100 Maneiras");
        maneiras.setAvgPrice(60);
        maneiras.setEmail("info@100maneiras.com");
        maneiras.setPhone("910918181");
        maneiras.setWorkingHours("19h - 22h30");
        maneiras.setClosed("Always Open");
        add(maneiras);

        Entertainment mini = new Restaurant();
        mini.setName("Mini Bar");
        mini.setAvgPrice(60);
        mini.setEmail("minibar@gmail.com");
        mini.setPhone("211305393");
        mini.setWorkingHours("18h45 - 22h30");
        mini.setClosed("Always Open");
        add(mini);

        Entertainment restaurant4 = new Restaurant();
        restaurant4.setName("Kanazawa");
        restaurant4.setAvgPrice(50);
        restaurant4.setEmail("reservas@kanazawa.com.pt");
        restaurant4.setPhone("213010292");
        restaurant4.setWorkingHours("19h - 23h");
        restaurant4.setClosed("Sunday");
        add(restaurant4);

        Entertainment restaurant5 = new Restaurant();
        restaurant5.setName("Gambrinus");
        restaurant5.setAvgPrice(55);
        restaurant5.setEmail("reservas@gambrinus.pt");
        restaurant5.setPhone("213421466");
        restaurant5.setWorkingHours("12h - 22h30");
        restaurant5.setClosed("Saturday - Sunday");
        add(restaurant5);

        Entertainment tibatanos = new Restaurant();
        tibatanos.setName("Os Tibetanos");
        tibatanos.setAvgPrice(15);
        tibatanos.setEmail("@mail.com");
        tibatanos.setPhone("952345fdsdsf");
        tibatanos.setWorkingHours("10:00 - 22:00");
        tibatanos.setClosed("Sunday");
        add(tibatanos);

        Entertainment restaurant7 = new Restaurant();
        restaurant7.setName("Belcanto");
        restaurant7.setAvgPrice(150);
        restaurant7.setEmail("info@belcanto.com");
        restaurant7.setPhone("213420607");
        restaurant7.setWorkingHours("12h30 - 15h, 18h45 - 22h30");
        restaurant7.setClosed("Sunday - Monday");
        add(restaurant7);

        Entertainment fifty = new Restaurant();
        fifty.setName("50 Seconds");
        fifty.setAvgPrice(90);
        fifty.setEmail("50seconds@myriadhotels.com");
        fifty.setPhone("211525380");
        fifty.setWorkingHours("12h - 15h, 19h - 23h");
        fifty.setClosed("Sunday - Monday");
        add(fifty);

        Entertainment restaurant9 = new Restaurant();
        restaurant9.setName("SUD Lisboa");
        restaurant9.setAvgPrice(50);
        restaurant9.setEmail("sudlisboa@sanahotels.com");
        restaurant9.setPhone("211592700");
        restaurant9.setWorkingHours("12h - 22h");
        restaurant9.setClosed("Always Open");
        add(restaurant9);

        Entertainment restaurant10 = new Restaurant();
        restaurant10.setName("Faz Figura");
        restaurant10.setAvgPrice(40);
        restaurant10.setEmail("reservas@fazfigura.com");
        restaurant10.setPhone("218868981");
        restaurant10.setWorkingHours("12h30 - 15h, 19h - 23h");
        restaurant10.setClosed("Monday");
        add(restaurant10);

        Entertainment restaurant11 = new Restaurant();
        restaurant11.setName("JNCquoi");
        restaurant11.setAvgPrice(45);
        restaurant11.setEmail("jncquoi@amorimluxury.com");
        restaurant11.setPhone("219369900");
        restaurant11.setWorkingHours("12h - 22h30");
        restaurant11.setClosed("Saturday - Sunday");
        add(restaurant11);

        Entertainment restaurant12 = new Restaurant();
        restaurant12.setName("Faia");
        restaurant12.setAvgPrice(75);
        restaurant12.setEmail("faia@faia.pt");
        restaurant12.setPhone("213426742");
        restaurant12.setWorkingHours("20h - 02h");
        restaurant12.setClosed("Sunday");
        add(restaurant12);

        Entertainment vinho = new Restaurant();
        vinho.setName("Sr. Vinho");
        vinho.setAvgPrice(60);
        vinho.setEmail("reservas@srvinho.com.pt");
        vinho.setPhone("213972681");
        vinho.setWorkingHours("20h - 02h");
        vinho.setClosed("Sunday");
        add(vinho);

        Entertainment restaurant14 = new Restaurant();
        restaurant14.setName("Loja das Conservas");
        restaurant14.setAvgPrice(15);
        restaurant14.setEmail("geral@lojadasconservas.com");
        restaurant14.setPhone("911181210");
        restaurant14.setWorkingHours("10h - 20h");
        restaurant14.setClosed("Always Open");
        add(restaurant14);

        Entertainment restaurant15 = new Restaurant();
        restaurant15.setName("Solar dos Presuntos");
        restaurant15.setAvgPrice(40);
        restaurant15.setEmail("solardospresuntos@gmail.com");
        restaurant15.setPhone("213424253");
        restaurant15.setWorkingHours("12h - 22h30");
        restaurant15.setClosed("Sunday");
        add(restaurant15);




        Entertainment nature = new PreDate();
        nature.setName("Estrela Garden");
        nature.setWorkingHours("06h - 00h");
        nature.setClosed("Always Open");
        add(nature);

        Entertainment nature1 = new PreDate();
        nature1.setName("Nossa da Nossa Senhora do Monte Viewpoint");
        nature1.setWorkingHours("Always Open");
        nature1.setClosed("Always Open");
        add(nature1);

        Entertainment nature2 = new PreDate();
        nature2.setName("Graça Viewpoint");
        nature2.setWorkingHours("12h - 00h");
        nature2.setClosed("Always Open");
        add(nature2);

        Entertainment nature3 = new PreDate();
        nature3.setName("Torel Garden");
        nature3.setWorkingHours("06h - 22h");
        nature3.setClosed("Always Open");
        add(nature3);

        Entertainment nature4 = new PreDate();
        nature4.setName("Ribeira das Naus");
        nature4.setWorkingHours("Always Open");
        nature4.setClosed("Always Open");
        add(nature4);

        Entertainment gulbenkian = new PreDate();
        gulbenkian.setName("Gulbenkian Garden");
        gulbenkian.setWorkingHours("08h - 19h30");
        gulbenkian.setClosed("Always Open");
        add(gulbenkian);

        Entertainment nature6 = new PreDate();
        nature6.setName("Adamastor Viewpoint");
        nature6.setWorkingHours("08h - 23h");
        nature6.setClosed("Always Open");
        add(nature6);

        Entertainment nature7 = new PreDate();
        nature7.setName("Monsanto Forest Park");
        nature7.setWorkingHours("08h - 23h");
        nature7.setClosed("Always Open");
        add(nature7);


        Entertainment allFlowers = new PreDate();
        allFlowers.setName("All Flowers");
        allFlowers.setAvgPrice(20);
        allFlowers.setWorkingHours("Online");
        add(allFlowers);

        Entertainment service1 = new PreDate();
        service1.setName("Seaventy");
        service1.setAvgPrice(125);
        service1.setEmail("@gmail.com");
        service1.setPhone("213424253");
        service1.setWorkingHours("09h - 18h");
        add(service1);

        Entertainment escape = new PreDate();
        escape.setName("Escape In");
        escape.setAvgPrice(20);
        escape.setEmail("@gmail.com");
        escape.setPhone("213424253");
        escape.setWorkingHours("Online");
        add(escape);

        Entertainment afrodite = new PreDate();
        afrodite.setName("Afrodite Sex Shop");
        afrodite.setAvgPrice(20);
        afrodite.setEmail("@gmail.com");
        afrodite.setPhone("213424253");
        afrodite.setWorkingHours("Online");
        add(afrodite);

        Entertainment service4 = new PreDate();
        service4.setName("Amsterdam Store Lisboa");
        service4.setAvgPrice(15);
        service4.setEmail("@gmail.com");
        service4.setPhone("213424253");
        service4.setWorkingHours("10h - 19h");
        add(service4);

        Entertainment service5 = new PreDate();
        service5.setName("Cannabis Care Portugal");
        service5.setAvgPrice(15);
        service5.setEmail("@gmail.com");
        service5.setPhone("213424253");
        service5.setWorkingHours("10h - 19h");
        add(service5);

        Entertainment service6 = new PreDate();
        service6.setName("Bike Bar Tours");
        service6.setAvgPrice(25);
        service6.setEmail("@gmail.com");
        service6.setPhone("213424253");
        service6.setWorkingHours("08h - 22h");
        add(service6);




        Entertainment culture = new PreDate();
        culture.setName("Zoo");
        culture.setAvgPrice(25);
        culture.setEmail("solardospresuntos@gmail.com");
        culture.setPhone("213424253");
        culture.setWorkingHours("12h - 22h30");
        add(culture);

        Entertainment culture1 = new PreDate();
        culture1.setName("Oceanarium");
        culture1.setAvgPrice(25);
        culture1.setEmail("solardospresuntos@gmail.com");
        culture1.setPhone("213424253");
        culture1.setWorkingHours("12h - 22h30");
        add(culture1);

        Entertainment tiles = new PreDate();
        tiles.setName("Tiles Museum");
        tiles.setAvgPrice(15);
        tiles.setEmail("solardospresuntos@gmail.com");
        tiles.setPhone("213424253");
        tiles.setWorkingHours("12h - 22h30");
        add(tiles);

        Entertainment culture3 = new PreDate();
        culture3.setName("Jerónimos Monasterium");
        culture3.setAvgPrice(10);
        culture3.setEmail("solardospresuntos@gmail.com");
        culture3.setPhone("213424253");
        culture3.setWorkingHours("12h - 22h30");
        add(culture3);

        Entertainment culture4 = new PreDate();
        culture4.setName("Sé Cathedral");
        culture4.setAvgPrice(10);
        culture4.setEmail("solardospresuntos@gmail.com");
        culture4.setPhone("213424253");
        culture4.setWorkingHours("12h - 22h30");
        add(culture4);

        Entertainment culture5 = new PreDate();
        culture5.setName("Coach Museum");
        culture5.setAvgPrice(10);
        culture5.setEmail("solardospresuntos@gmail.com");
        culture5.setPhone("213424253");
        culture5.setWorkingHours("12h - 22h30");
        add(culture5);

        Entertainment culture6 = new PreDate();
        culture6.setName("Navy Museum");
        culture6.setAvgPrice(10);
        culture6.setEmail("solardospresuntos@gmail.com");
        culture6.setPhone("213424253");
        culture6.setWorkingHours("12h - 22h30");
        add(culture6);

        Entertainment culture7 = new PreDate();
        culture7.setName("Ladra Street Fair");
        culture7.setAvgPrice(10);
        culture7.setEmail("solardospresuntos@gmail.com");
        culture7.setPhone("213424253");
        culture7.setWorkingHours("12h - 22h30");
        add(culture7);



        Entertainment transport = new Transport();
        transport.setName("Tuk Tuk Tours");
        transport.setAvgPrice(10);
        transport.setEmail("@mail.com");
        transport.setPhone("952345");
        transport.setWorkingHours("10:00 - 22:00");
        add(transport);

        Entertainment transport1 = new Transport();
        transport1.setName("Uber Black");
        transport1.setAvgPrice(20);
        transport1.setEmail("@mail.com");
        transport1.setPhone("952345");
        transport1.setWorkingHours("10:00 - 22:00");
        add(transport1);

        Entertainment transport2 = new Transport();
        transport2.setName("Uber X");
        transport2.setAvgPrice(10);
        transport2.setEmail("@mail.com");
        transport2.setPhone("952345");
        transport2.setWorkingHours("10:00 - 22:00");
        add(transport2);

        Entertainment transport3 = new Transport();
        transport3.setName("E-Cooltra");
        transport3.setAvgPrice(5);
        transport3.setEmail("@mail.com");
        transport3.setPhone("952345");
        transport3.setWorkingHours("10:00 - 22:00");
        add(transport3);

        Entertainment transport4 = new Transport();
        transport4.setName("VIP Limousines");
        transport4.setAvgPrice(75);
        transport4.setEmail("@mail.com");
        transport4.setPhone("952345");
        transport4.setWorkingHours("10:00 - 22:00");
        add(transport4);

        Entertainment transport5 = new Transport();
        transport5.setName("Gira Bikes");
        transport5.setAvgPrice(5);
        transport5.setEmail("@mail.com");
        transport5.setPhone("952345");
        transport5.setWorkingHours("10:00 - 22:00");
        add(transport5);




        Entertainment ritz = new PosDate();
        ritz.setName("Ritz Hotel");
        ritz.setAvgPrice(250);
        ritz.setEmail("@mail.com");
        ritz.setPhone("952345");
        ritz.setWorkingHours("10:00 - 22:00");
        add(ritz);

        Entertainment posDate1 = new PosDate();
        posDate1.setName("Tivoli Hotel");
        posDate1.setAvgPrice(100);
        posDate1.setEmail("@mail.com");
        posDate1.setPhone("952345");
        posDate1.setWorkingHours("10:00 - 22:00");
        add(posDate1);

        Entertainment chapito = new PosDate();
        chapito.setName("Chapitô");
        chapito.setAvgPrice(5);
        chapito.setEmail("@mail.com");
        chapito.setPhone("9523454234");
        chapito.setWorkingHours("10:00 - 22:00");
        add(chapito);

        Entertainment posDate3 = new PosDate();
        posDate3.setName("Loucos e Sonhadores");
        posDate3.setAvgPrice(5);
        posDate3.setEmail("@mail.com");
        posDate3.setPhone("952523525");
        posDate3.setWorkingHours("10:00 - 22:00");
        add(posDate3);

        Entertainment silk = new PosDate();
        silk.setName("Silk Club");
        silk.setAvgPrice(15);
        silk.setEmail("@mail.com");
        silk.setPhone("915632624");
        silk.setWorkingHours("10:00 - 22:00");
        add(silk);

        Entertainment posDate5 = new PosDate();
        posDate5.setName("Foxtrot Bar");
        posDate5.setAvgPrice(10);
        posDate5.setEmail("@mail.com");
        posDate5.setPhone("9274674r4");
        posDate5.setWorkingHours("10:00 - 22:00");
        add(posDate5);

        Entertainment posDate6 = new PosDate();
        posDate6.setName("Pavilhão Chinês");
        posDate6.setAvgPrice(10);
        posDate6.setEmail("@mail.com");
        posDate6.setPhone("952345");
        posDate6.setWorkingHours("10:00 - 22:00");
        add(posDate6);

        Entertainment crazy = new Crazy();
        crazy.setName("Demais");
        crazy.setAvgPrice(10);
        crazy.setEmail("@mail.com");
        crazy.setPhone("952345");
        crazy.setWorkingHours("10:00 - 22:00");
        add(crazy);
    }

}
