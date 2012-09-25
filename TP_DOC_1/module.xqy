(: Fonction produitParCouleur :)
module namespace local = "http://localhost";
declare function local:produitParCouleur
	($couleur) {
		doc("produit.xml")/listeProduit/produit[Couleur=$couleur]
	};
	
declare function local:fournisseurParProduit
	($codep as xs:string) {
		let $v := doc("maFourniture.xml")/listeFourniture/fourniture[P=$codep]/F
		return doc("fournisseur.xml")/listeFournisseur/fournisseur[F=$v]
	};