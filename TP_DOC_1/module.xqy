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
	
declare function local:fournisseurParProduit2 ($codep as xs:string) {
	(:for $v in distinct-values(
		
	
		
	) return <fournisseur>{$v}</fournisseur>:)
	
	for $fourniture in doc("maFourniture.xml")/listeFourniture/fourniture,
		$fournisseur in doc("fournisseur.xml")/listeFournisseur/fournisseur
	where
		$fourniture/P=$codep and
		$fourniture/F=$fournisseur/F 
	return <fournisseur>{$fournisseur/Nom/text()}</fournisseur>
};
	