/* Insertion des catégories */
INSERT INTO `categorie` (`nom`)
VALUES  ('Types de sous-marins'),
        ('Histoire'),
        ('Explications');

/* Insertion d'articles pour tests */
INSERT INTO `article` (`titre`, `description_courte`, `texte`, `date_modification`, `actif`, `image_src`, `categorie_id`, `utilisateur_id`)
    VALUES  ('Sous-marins allemands de Type XXI', 'Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un s', 'Le type XXI est un sous-marin révolutionnaire : c''est le premier véritable "sous-marin" moderne, conçu pour fonctionner intégralement en plongée. Jusqu''alors ces bâtiments étaient des "submersibles", conçus pour opérer essentiellement en surface, ne plongeant qu''en cas de menace, et avec de mauvaises performances en plongée en ce qui concerne la vitesse (quelques noeuds) et l''autonomie (quelques heures et quelques dizaines de milles).', null, true, null, 1, 1),
            ('Premier sous-marin militaire', 'Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin', 'Le premier sous-marin militaire pleinement opérationnel est électrique, construit par l''Espagnol Isaac Peral pour la Marine espagnole. Lancé le 8 septembre 1888, il possède deux torpilles, de nouveaux systèmes pour l''air, ainsi qu''une forme de coque, une hélice et des gouvernes préfigurant les sous-marins futurs. Il pouvait aller à 10 nœuds sous l''eau, mais ses batteries avaient une courte durée de vie.

En France, le Gymnote lancé le 24 septembre 1888 est également un sous-marin tout électrique équipé de batteries au plomb. Il sera suivi par la suite par le Morse en 1899, puis la série des quatre Farfadet en 1901. La distance franchissable passait à 100 miles.

Le premier sous-marin réellement opérationnel est le Gymnote de 1887, construit par  les Français Henri Dupuy de Lôme et Gustave Zédé. Long de 17m, il est propulsé par un moteur électrique de 50 chevaux, atteint 8 noeuds en surface, 4 en plongée.', null, false, null, 2, 2);

/* Insertion d'utilisateurs pour tests */
INSERT INTO `utilisateur` (`nom_utilisateur`, `mot_de_passe`, `email`, `email_verifiee`, `cle_activation`, `date_activation`, `actif`)
VALUES  ('Mymy', '13111981', 'mymy@yahoo.com', true, null, null, false),
        ('Gilles', '12051969', 'gillout@bbox.fr', true, null, null, true),
        ('Caroline', '18022014', 'line@yahoo.fr', false, null, null, true);
