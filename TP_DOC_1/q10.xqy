<result>{	
	for $v in distinct-values(
		for $origines in //produit/Origine
			
		<origine ville="{}">
			for $p in //produit
			where $p/Origine=$Origines
			return
			<produit>{
			 	$p/Nom_p
				local:fournisseurParProduit($p/P)/Nom
			} 
			</produit>	
	
		
	)return {$v}
</result>