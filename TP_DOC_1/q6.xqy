<result>{
	for $v in distinct-values(
		for $fournisseur in //fournisseur,
			$maFourniture in //fourniture,
			$produit in //produit
		where
			$maFourniture/F = $fournisseur/F and
			$maFourniture/P = $produit/P and
			$produit/Couleur = 'vert' and
			$fournisseur/Nom = 'Barnibus'
		return
			$produit/Nom_p/text()
	) return <produit>{$v}</produit>
}
</result>