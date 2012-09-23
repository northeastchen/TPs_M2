
import module namespace local ="http://localhost" at "q3.xqy";
<result>{
	count(local:produitParCouleur('vert')[Origine='Riec'])
	}
</result>