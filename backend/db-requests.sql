/* Insertion des catégories */
INSERT INTO `categorie` (`nom`)
VALUES  ('Types de sous-marins'),
        ('Histoire'),
        ('Explications');

/* Insertion d'articles pour tests */
INSERT INTO `article` (`titre`, `description_courte`, `texte`, `date_modification`, `actif`, `image_src`, `categorie_id`, `utilisateur_id`)
    VALUES  ('Sous-marins allemands de Type XXI', 'Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un sous- Le type XXI est un s', 'Le type XXI est un sous-marin révolutionnaire : c''est le premier véritable "sous-marin" moderne, conçu pour fonctionner intégralement en plongée. Jusqu''alors ces bâtiments étaient des "submersibles", conçus pour opérer essentiellement en surface, ne plongeant qu''en cas de menace, et avec de mauvaises performances en plongée en ce qui concerne la vitesse (quelques noeuds) et l''autonomie (quelques heures et quelques dizaines de milles).', null, true, 'article-1.png', 1, 1),
            ('Premier sous-marin militaire', 'Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin mil Le premier sous-marin', 'Le premier sous-marin militaire pleinement opérationnel est électrique, construit par l''Espagnol Isaac Peral pour la Marine espagnole. Lancé le 8 septembre 1888, il possède deux torpilles, de nouveaux systèmes pour l''air, ainsi qu''une forme de coque, une hélice et des gouvernes préfigurant les sous-marins futurs. Il pouvait aller à 10 nœuds sous l''eau, mais ses batteries avaient une courte durée de vie.

En France, le Gymnote lancé le 24 septembre 1888 est également un sous-marin tout électrique équipé de batteries au plomb. Il sera suivi par la suite par le Morse en 1899, puis la série des quatre Farfadet en 1901. La distance franchissable passait à 100 miles.

Le premier sous-marin réellement opérationnel est le Gymnote de 1887, construit par  les Français Henri Dupuy de Lôme et Gustave Zédé. Long de 17m, il est propulsé par un moteur électrique de 50 chevaux, atteint 8 noeuds en surface, 4 en plongée.', null, false, 'article-2.png', 2, 2)
            ('Le Schnorchel', 'Les sous-marins Diesel ont besoin d''air pour faire tourner leurs moteurs, et transportent à l’époque de la seconde guerre d''énormes batteries pour la propulsion sous-marine ; ceci limite leur vitesse et rayon d''action.', 'Les sous-marins Diesel ont besoin d''air pour faire tourner leurs moteurs, et transportent à l’époque de la seconde guerre d''énormes batteries pour la propulsion sous-marine ; ceci limite leur vitesse et rayon d''action. Le schnorchel, une invention hollandaise d''avant la guerre, a été utilisée sur les sous-marins allemands pour utiliser les moteurs Diesel juste sous la surface afin d''éviter la détection visuelle et radar. La marine allemande a aussi expérimenté des moteurs au peroxyde d’hydrogène, en rencontrant de grandes difficultés techniques. Les Alliés ont aussi essayé différentes techniques pour détecter un sous-marin naviguant au schnorchel, dont des senseurs chimiques pour « renifler » l''échappement des sous-marins. Exemple de sous-marin à propulsion diesel-électrique utilisant le schnorchel : le sous-marin soviétique de la classe Foxtrot.', null, true, 'article-3.png', 3, 1);

/* Insertion des roles */
INSERT INTO `role` (`nom`)
VALUES  ('MEMBRE'),
        ('ADMIN');

/* Insertion d'utilisateurs pour tests */
INSERT INTO `utilisateur` (`nom_utilisateur`, `mot_de_passe`, `email`, `email_verifiee`, `cle_activation`, `date_activation`, `actif`, `role_id`)
VALUES  ('Mymy', '13111981', 'mymy@yahoo.com', true, null, null, true, 1),
        ('Gilles', '12051969', 'gillout@bbox.fr', true, null, null, true, 2),
        ('Caroline', '18022014', 'line@yahoo.fr', false, null, null, false, 1);
