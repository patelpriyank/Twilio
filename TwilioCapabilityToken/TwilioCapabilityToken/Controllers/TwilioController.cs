using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Twilio;

namespace TwilioCapabilityToken.Controllers
{
    public class TwilioController : ApiController
    {
        //[ActionName("Search")]
        [HttpGet]
        public string GetToken()
        {
            string accountSid = "ACa0959a66f44d578382bc1db60a452742";
            string authToken = "e610c3b7667dc6453ac93f2fb1fac2fd";
            var capability = new TwilioCapability (accountSid, authToken);

            //To allow incoming connections to a device you need to give the device a client name
            string clientName = "motoX";
            string appSid = "";
            capability.AllowClientIncoming()
            capability.AllowClientOutgoing(appSid);
            token = capability.GenerateToken();

        }
    }
}
