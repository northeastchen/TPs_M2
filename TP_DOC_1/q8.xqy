(:module namespace local = "http://localhost";:)
declare namespace local = "http://localhost";
declare function local:fournisseurParProduit
	($codep as xs:string) {
		let $v := doc("maFourniture.xml")/listeFourniture/fourniture[P=$codep]/F
		return doc("fournisseur.xml")/listeFournisseur/fournisseur[F=$v]
	};
		
<result>{
	local:fournisseurParProduit('p4')/Nom
	}
</result>