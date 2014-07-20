using System.Web.Http;
using Twilio;

namespace Caddy.Twilio.Backend.Controllers
{
    public class TwilioController : ApiController
    {
        /*
         To allow incoming connections to a device you need to give the device a client name. 
         A connection attempt to this client name will trigger an incoming event in your environment. 
         In twilio.js an incoming connection attempt triggers the Twilio.Device.incoming event handler. 
         */
        const string ClientName = "motoX";
        const string AccountSid = "ACa0959a66f44d578382bc1db60a452742";
        const string AuthToken = "e610c3b7667dc6453ac93f2fb1fac2fd";
        private const string ApplicationSid = "TestCaddyAndroidApp";

        //[ActionName("Search")]
        [HttpGet]
        public string GetToken(string clientId)
        {
            var capability = new TwilioCapability (AccountSid, AuthToken);
            
            /*
             A device configured with this token will receive incoming connections 
             anytime someone attempts to connect to "motoX"
             */
            capability.AllowClientIncoming(clientId);

            /*
             To make an outgoing connection from a device, you'll need to configure a capability token with the SID of a Twilio Application 
             so that Twilio will know what VoiceUrl to use to handle the connection.
             */
            capability.AllowClientOutgoing(ApplicationSid);

            /*
             If the token expires while the device has an active connection, the connection will not be terminated, 
             but the device will need to be re-initialized with a valid token before attempting 
             or receiving another connection.
             */
            /*
             * Note:- Note that the token generated is valid for 1 hour unless otherwise specified. 
             * To specify a different period of time, pass in the number of seconds 
             * as an integer parameter to generateToken() -- for example, for a token that expires after 5 minutes, 
             * call generateToken(300). The maximum allowed lifetime for a token is 24 hours.
             */
            var token = capability.GenerateToken();

            return token;
        }

        
    }
}
