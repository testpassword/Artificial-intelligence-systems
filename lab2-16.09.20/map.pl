% rules
road(From, To, Distance) :- From @< To, road(To, From, Distance).

% facts
road(vilnus, brest, 531).
road(vitebsk, brest, 638).
road(vitebsk, vilnus, 360).
road(voronez, vitebsk, 869).
road(voronez, volgograd, 581).
road(volgograd, vitebsk, 1455).
road(vitebsk, niz-novgorod, 911).
road(vilnus, daugavpils, 211).
road(kaliningrad, brest, 699).
road(kaliningrad, vilnus, 333).
road(kaunas, vilnus, 102).
road(kiev, vilnus, 734).
road(kiev, zitomir, 131).
road(zitomir, doneck, 863).
road(zitomir, volgograd, 1493).
road(kishinev, kiev, 467).
road(kishinev, doneck, 812).
road(saint-petersburg, vitebsk, 602).
road(saint-petersburg, kaliningrad, 739).
road(saint-petersburg, riga, 641).
road(moscow, kazan, 815).
road(moscow, niz-novgorod, 411).
road(moscow, minsk, 690).
road(moscow, doneck, 1084).
road(moscow, saint-petersburg, 664).
road(murmansk, saint-petersburg, 1412).
road(murmansk, minsk, 2238).
road(orel, vitebsk, 522).
road(orel, doneck, 709).
road(orel, moscow, 368).
road(odessa, kiev, 487).
road(riga, kaunas, 267).
road(tallinn, riga, 308).
road(kharkov, kiev, 471).
road(kharkov, simpheropol, 639).
road(iroslavl, voronez, 739).
road(iroslavl, minsk, 940).
road(ufa, kazan, 525).
road(ufa, samara, 461).