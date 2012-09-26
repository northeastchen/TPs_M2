import module namespace local = "http://localhost" at "module.xqy";
<result>{	
	for $origine in distinct-values(
		//produit/Origine
	)return 
		<origine ville="{$origine}">{
			for $p in //produit
			where $p/Origine=$origine
			return
				<produit>{
					<nom>{$p/Nom_p/text()}</nom>,
					local:fournisseurParProduit2($p/P)
				}</produit>	
			
		}</origine>
}
</result>