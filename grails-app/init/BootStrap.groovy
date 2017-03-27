import database_5g.Mainpolicies
import database_5g.Secondarypolicy
import database_5g.Userdatabase

class BootStrap {

    def init = { servletContext ->
	
	new Mainpolicies(cesid:"Aalto-In-User", direction:"Ingress", ipversion:"4", entity:"User", rloc:"first").save()
	
	new Mainpolicies(cesid:"Helsinki-Bo-CES", direction:"Both", ipversion:"6", entity:"Firewall", rloc:"second").save()

	new Mainpolicies(cesid:"Tampere-Eg-CES", direction:"Egress", ipversion:"6", entity:"Firewall", rloc:"Third").save()

	new Mainpolicies(cesid:"Turku-Bo-User", direction:"Both", ipversion:"4", entity:"User", rloc:"Fourth").save()



	new Secondarypolicy(policyname:"Prepaid_Aalto", ratelimit:"256", payload:"4", ttl:"20", dstep:"123", caep:"a1a1", ack:"yes", mainpolicies:"1").save()
	
	new Secondarypolicy(policyname:"Postpaid_Turku_User", dstep:"456", caep:"a2a2", ack:"yes", mainpolicies:"4", ratelimit:"512", ttl:"30", payload:"4" ).save()

	new Secondarypolicy(policyname:"Premium_Tampere_CES", dstep:"789", caep:"a3a3", ack:"yes", mainpolicies:"3", ratelimit:"1024", ttl:"30", payload:"eth" ).save()

	new Secondarypolicy(policyname:"Complementary_Helsinki_CES", dstep:"1234", caep:"a4a4", ack:"yes", mainpolicies:"2", ratelimit:"2048", ttl:"40", payload:"6" ).save()



	new Userdatabase(username:"Hassaan", fqdn:"hassaan.tampere.fi", msisdn:"+3584652154", secondarypolicies:"3").save()
	new Userdatabase(username:"Ana", fqdn:"goulart.aalto.fi", msisdn:"+3584364576", secondarypolicies:"2").save()
	new Userdatabase(username:"Raimo", fqdn:"kantola.aalto.fi", msisdn:"+3584865465", secondarypolicies:"1").save()
	new Userdatabase(username:"Mayor", fqdn:"mayor.helsinki.fi", msisdn:"+3582345566", secondarypolicies:"4").save()
	new Userdatabase(username:"Aamir", fqdn:"nepal.aalto.fi", msisdn:"+3589662454", secondarypolicies:"2").save()
	new Userdatabase(username:"Tulla", fqdn:"president.aalto.fi", msisdn:"+3585544554", secondarypolicies:"4").save()
	new Userdatabase(username:"Hammad", fqdn:"Kabir.aalto.fi", msisdn:"+3589695332", secondarypolicies:"1").save()
	new Userdatabase(username:"Saba", fqdn:"ahsan.aalto.fi", msisdn:"+3588745345", secondarypolicies:"2").save()
	
    }
    def destroy = {
    }
}
