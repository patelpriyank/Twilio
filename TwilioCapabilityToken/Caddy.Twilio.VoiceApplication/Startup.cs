using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Caddy.Twilio.VoiceApplication.Startup))]
namespace Caddy.Twilio.VoiceApplication
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
