<result>{
	for $v in distinct-values(
		(:for $maFourniture in //fourniture
		where
			some $c in $maFourniture/P satisfies $c = 'p4'
		return
			$maFourniture/F:)
		
		for $f1 in doc("maFourniture.xml")/listeFourniture/fourniture[P='p2'], 
		    $f2 in doc("maFourniture.xml")/listeFourniture/fourniture[P='p4']
		where $f1/F = $f2/F 
		return $f2/F
	) return <F>{$v}</F>
}
</result>