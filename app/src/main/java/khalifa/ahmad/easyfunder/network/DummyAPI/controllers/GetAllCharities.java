package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.charity.Metrics;
import khalifa.ahmad.easyfunder.models.charity.builders.CharityBuilder;
import khalifa.ahmad.easyfunder.models.charity.builders.MetricsBuilder;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class GetAllCharities extends APIController {

    public GetAllCharities() {}

    @Override
    public Object execute() {
        ArrayList<ArrayList<Charity>> charities = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            charities.add(new ArrayList<Charity>());
        }

        charities.get(0).addAll(
                Arrays.asList(

                        new Charity[]{
                                new CharityBuilder()
                                        .name("Actors and Others for Animals")
                                        .category(Charity.CATEGORY_ANIMALS)
                                        .rate(3.4)
                                        .mission("Founded in 1971, Actors and Others for Animals is dedicated to the promotion of the humane treatment of animals. Our main mission is to curb the pet overpopulation problem by subsidizing spay/neuter surgeries. Together with other vital services, we are there to help pet guardians living on a low and/or fixed income care for their beloved companions. We are a community based animal welfare organization serving the greater Los Angeles area and surrounding counties. Our programs include: pet overpopulation, spay/neuter help, pet care, emergency medical help, pet-assisted therapy, humane education, and a feral cats assistance program.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("573,108")
                                                .totalRevenue("625,756")
                                                .programExpenses("659,258")
                                                .fundraisingExpenses("28,165")
                                                .totalFunctionalExpenses("715,594")
                                                .netAssets("2,848,861")
                                                .build()
                                ).build(),

                                new CharityBuilder()
                                        .name("Adopt A Pet.com")
                                        .category(Charity.CATEGORY_ANIMALS)
                                        .rate(4.1)
                                        .mission("Adopt-a-Pet.com (formerly 1-800-Save-A-Pet.com) is a pet adoption charity that helps shelters, humane societies, SPCAs, pet rescue groups, and pet adoption agencies advertise their homeless pets to adopters for free. We're all about getting homeless pets into homes. We use the power of TV, the Internet and a toll-free phone number to connect adopters with shelter pets and help pets go from alone to adopted. We're working to help the good people at shelters and rescue groups find homes for their pets.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("2,874,609")
                                                .totalRevenue("2,916,013")
                                                .programExpenses("2,094,725")
                                                .fundraisingExpenses("369,289")
                                                .totalFunctionalExpenses("2,630,190")
                                                .netAssets("1,368,573")
                                                .build()
                                ).build(),

                                new CharityBuilder()
                                        .name("Alley Cat Allies")
                                        .category(Charity.CATEGORY_ANIMALS)
                                        .rate(3.5)
                                        .mission("Founded in 1990, Alley Cat Allies is dedicated to the protection and humane treatment of cats. Our mission is to end the killing of cats and lead the movement for their humane care. Alley Cat Allies has charted a course set on animal control and shelter industry reform and humane treatment through activities including: advocating for pounds and shelters to keep public records of animal intake and kill rates, for public and mandatory government oversight, and for increased pound and shelter accountability; mobilizing and educating the public and leading the national movement to end the killing of cats and to protect and improve their lives; and supporting the efforts of, and acting as the national voice for, thousands of individuals and groups across the U.S. who provide humane care for stray and feral cats.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("8,173,192")
                                                .totalRevenue("8,597,648")
                                                .programExpenses("6,282,385")
                                                .fundraisingExpenses("525,104")
                                                .totalFunctionalExpenses("7,390,429")
                                                .netAssets("5,918,253")
                                                .build()
                                ).build(),

                                new CharityBuilder()
                                        .name("Alley Cat Rescue")
                                        .category(Charity.CATEGORY_ANIMALS)
                                        .rate(3.4)
                                        .mission("Alley Cat Rescue (ACR) works to protect cats on several levels: locally through rescue, rehabilitation and adoption of cats and nationally through a network of Cat Action Teams, called CAT. ACR is dedicated to the health, well-being and welfare of all cats: domestic, stray, abandoned and feral. ACR is helping to solve the crisis and tragedy of unwanted and abandoned cats. We are saving lives with innovative hands-on programs; we have rescued thousands of cats and placed them in loving homes; we assist with all aspects of feral cat care, wildlife predation and rabies control; and we also provide information on cat health, cat behavior, feline diseases, and special needs.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("1,489,131")
                                                .totalRevenue("1,533,988")
                                                .programExpenses("1,203,350")
                                                .fundraisingExpenses("534,650")
                                                .totalFunctionalExpenses("1,815,031")
                                                .netAssets("759,030")
                                                .build()
                                ).build(),

                                new CharityBuilder()
                                        .name("Anderson Animal Shelter")
                                        .category(Charity.CATEGORY_ANIMALS)
                                        .rate(3.1)
                                        .mission("Anderson Animal Shelter (AAS) was incorporated in 1966 and is the largest privately funded animal welfare organization in the Fox Valley area. The mission of AAS is to improve the lives of pets and people through service, education and advocacy. Anderson Animal Shelter cares for over 3,000 homeless pets each year, with a live release rate of over 96%. A variety of other services are also offered to the public. These include: low-cost spay/neuter, dog training and humane education programming.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("904,767")
                                                .totalRevenue("1,378,707")
                                                .programExpenses("897,514")
                                                .fundraisingExpenses("147,418")
                                                .totalFunctionalExpenses("1,176,653")
                                                .netAssets("2,332,336")
                                                .build()
                                ).build()
                        }
                )
        );
        charities.get(1).addAll(
                Arrays.asList(

                        new Charity[]{
                                new CharityBuilder()
                                        .name("Abraham Lincoln Presidential Library Foundation")
                                        .category(Charity.CATEGORY_ARTS)
                                        .rate(3.5)
                                        .mission("The Abraham Lincoln Presidential Library Foundation supports the educational and cultural programming of the Abraham Lincoln Presidential Library and Museum; fosters Lincoln scholarship through the acquisition and publication of documentary materials relating to Lincoln and his era; and promotes a greater appreciation of history through exhibits, conferences, publications, online services, and other activities designed to promote historical literacy.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("2,509,802")
                                                .totalRevenue("3,429,921")
                                                .programExpenses("2,301,910")
                                                .fundraisingExpenses("550,158")
                                                .totalFunctionalExpenses("3,233,819")
                                                .netAssets("22,326,955")
                                                .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("American Society for Yad Vashem")
                                        .category(Charity.CATEGORY_ARTS)
                                        .rate(4.1)
                                        .mission("Founded in 1981 by a group of Holocaust survivors, and spearheaded by Eli Zborowski, the American Society for Yad Vashem works in partnership with Yad Vashem, the Holocaust Martyrs' and Heroes' Remembrance Authority in Jerusalem to support their efforts in the areas of commemoration, education, research, capital improvement and special projects. Yad Vashem was established in 1953 by the Israeli Parliament (Knesset) and was entrusted with the task of commemorating the six million murdered by the Nazis and their collaborators. It mandates Holocaust remembrance, commemoration, and education to ensure the lessons of the Holocaust are secured for posterity.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("15,542,207")
                                                .totalRevenue("16,396,191")
                                                .programExpenses("9,610,192")
                                                .fundraisingExpenses("1,270,798")
                                                .totalFunctionalExpenses("11,786,359")
                                                .netAssets("52,882,180")
                                                .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Archaeological Conservancy")
                                        .category(Charity.CATEGORY_ARTS)
                                        .rate(2.2)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("15,542,207")
                                                .totalRevenue("16,396,191")
                                                .programExpenses("9,610,192")
                                                .fundraisingExpenses("1,270,798")
                                                .totalFunctionalExpenses("11,786,359")
                                                .netAssets("52,882,180")
                                                .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Archaeology Southwest")
                                        .category(Charity.CATEGORY_ARTS)
                                        .rate(3.1)
                                        .mission("Founded in 1989, Archaeology Southwest has practiced a holistic, conservation-based approach to exploring the places of the past. We call this Preservation Archaeology. By exploring what makes a place special, sharing this knowledge in innovative ways, and enacting flexible site protection strategies, we foster meaningful connections to the past and respectfully safeguard its irreplaceable resources.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("15,542,207")
                                                .totalRevenue("16,396,191")
                                                .programExpenses("9,610,192")
                                                .fundraisingExpenses("1,270,798")
                                                .totalFunctionalExpenses("11,786,359")
                                                .netAssets("52,882,180")
                                                .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Blithewold")
                                        .category(Charity.CATEGORY_ARTS)
                                        .rate(4.2)
                                        .mission("Since assuming stewardship responsibility for Blithewold in 1999, Blithewold, Inc. has concentrated on rebuilding a broad base of support for the property in the community and amongst horticultural enthusiasts to preserve New England's finest garden estate through excellence in horticulture and historic preservation, and by our example to teach and inspire others. Blithewold, a 33-acre summer estate with grand views of Narragansett Bay, is nationally significant in American history as one of the most fully developed and authentic examples of the Country Place era. The property features a 45-room mansion filled with family heirlooms framed by a series of lovely gardens that range in character from mysterious to exotic and from poetic to practical. An exceptional collection of rare and unusual plants, specimen trees, an accessible greenhouse, and whimsical stonework project a character that is romantic, fresh and inspiring – and unique to Blithewold.")
                                        .metrics(
                                        new MetricsBuilder()
                                                .totalContributions("15,542,207")
                                                .totalRevenue("16,396,191")
                                                .programExpenses("9,610,192")
                                                .fundraisingExpenses("1,270,798")
                                                .totalFunctionalExpenses("11,786,359")
                                                .netAssets("52,882,180")
                                                .build()
                                ).build()
                        }
                )
        );
        charities.get(2).addAll(
                Arrays.asList(

                        new Charity[]{
                                new CharityBuilder()
                                        .name("Akron Community Foundation")
                                        .category(Charity.CATEGORY_COMMUNITY)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Arizona Community Foundation")
                                        .category(Charity.CATEGORY_COMMUNITY)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Barnabas Foundation")
                                        .category(Charity.CATEGORY_COMMUNITY)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("California Community Foundation")
                                        .category(Charity.CATEGORY_COMMUNITY)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Community Foundation of New Jersey")
                                        .category(Charity.CATEGORY_COMMUNITY)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build()
                        }
                )
        );


        charities.get(3).addAll(
                Arrays.asList(

                        new Charity[]{
                                new CharityBuilder()
                                        .name("\"I Have a Dream\" Foundation")
                                        .category(Charity.CATEGORY_EDUCATION)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("10,000 Degrees")
                                        .category(Charity.CATEGORY_EDUCATION)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("ACE Scholarships")
                                        .category(Charity.CATEGORY_EDUCATION)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("American Indian Services")
                                        .category(Charity.CATEGORY_EDUCATION)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("American Quarter Horse Foundation")
                                        .category(Charity.CATEGORY_EDUCATION)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build()
                        }
                )
        );


        charities.get(4).addAll(
                Arrays.asList(

                        new Charity[]{
                                new CharityBuilder()
                                        .name("1000 Friends of Florida")
                                        .category(Charity.CATEGORY_ENVIRONMENT)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("350.org")
                                        .category(Charity.CATEGORY_ENVIRONMENT)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Acterra")
                                        .category(Charity.CATEGORY_ENVIRONMENT)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Alliance to Save Energy")
                                        .category(Charity.CATEGORY_ENVIRONMENT)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Amazon Watch")
                                        .category(Charity.CATEGORY_ENVIRONMENT)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build()
                        }
                )
        );


        charities.get(5).addAll(
                Arrays.asList(

                        new Charity[]{
                                new CharityBuilder()
                                        .name("Action on Smoking and Health")
                                        .category(Charity.CATEGORY_HEALTH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Alliance Medical Ministry")
                                        .category(Charity.CATEGORY_HEALTH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("American Foundation for Suicide Prevention")
                                        .category(Charity.CATEGORY_HEALTH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("AORN Foundation")
                                        .category(Charity.CATEGORY_HEALTH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Birmingham Health Care")
                                        .category(Charity.CATEGORY_HEALTH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build()
                        }
                )
        );


        charities.get(6).addAll(
                Arrays.asList(

                        new Charity[]{
                                new CharityBuilder()
                                        .name("Botanical Research Institute of Texas")
                                        .category(Charity.CATEGORY_RESEARCH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Clean Air Task Force")
                                        .category(Charity.CATEGORY_RESEARCH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Earthwatch Institute")
                                        .category(Charity.CATEGORY_RESEARCH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Long Now Foundation")
                                        .category(Charity.CATEGORY_RESEARCH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build(),

                                new CharityBuilder()
                                        .name("Mote Marine Laboratory")
                                        .category(Charity.CATEGORY_RESEARCH)
                                        .rate(new Random().nextDouble() * 5)
                                        .mission("The Archaeological Conservancy, established in 1980, is the only national non-profit organization dedicated to acquiring and preserving the best of our nation's remaining archaeological sites. Based in Albuquerque, New Mexico, the Conservancy also operates regional offices in Mississippi, Maryland, Ohio, and California. Every day, prehistoric and historic archaeological sites in the United States are lost forever--along with the precious information they contain. Modern-day looters use backhoes and bulldozers to recover artifacts for the international market. Urban development and agricultural methods such as land leveling and topsoil mining destroy ancient sites. The Conservancy protects these sites by acquiring the land on which they rest, preserving them for posterity.")
                                        .metrics(
                                                new MetricsBuilder()
                                                        .totalContributions("15,542,207")
                                                        .totalRevenue("16,396,191")
                                                        .programExpenses("9,610,192")
                                                        .fundraisingExpenses("1,270,798")
                                                        .totalFunctionalExpenses("11,786,359")
                                                        .netAssets("52,882,180")
                                                        .build()
                                        ).build()
                        }
                )
        );

        for (int i = 0; i < charities.size(); i++) {
            for (int j = 0; j < charities.get(i).size(); j++) {
                Global.database.addCharity(charities.get(i).get(j));
            }
        }

        ArrayList<ArrayList<Charity>> allCharities = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            allCharities.add(new ArrayList<Charity>());
        }

        ArrayList<Charity> databaseCharities = Global.database.getAllCharities();

        for (int i = 0; i < databaseCharities.size(); i++) {
            allCharities.get(databaseCharities.get(i).getCategory()).add(databaseCharities.get(i));
        }

        return allCharities;
    }
}