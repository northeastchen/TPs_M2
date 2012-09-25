import module namespace local = "http://localhost" at "module.xqy";
<result>{
	for $p in //produit
	return
		<produit nom="{$p/Nom_p}"> {
			local:fournisseurParProduit($p/P)/Nom
		} </produit>
}</result>