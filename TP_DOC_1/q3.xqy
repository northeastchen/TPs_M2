
(: Fonction produitParCouleur :)
module namespace local = "http://localhost";
(:declare namespace local = "http://localhost";:)
declare function local:produitParCouleur
	($couleur) {
		doc("produit.xml")/listeProduit/produit[Couleur=$couleur]
	};
(:	
<result> {
	local:produitParCouleur('vert')/Nom_p
} </result>
:)