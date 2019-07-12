from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class UserProfileInfo(models.Model):

    # Create relationship but don't inherit
    user = models.OneToOneField(User, on_delete=models.CASCADE)

    # Add additional attribs
    portfolio_site = models.URLField(blank=True)
    profile_pic = models.ImageField(upload_to='profile_pics',blank=True)

    def __str__(self):
        # Built-in attrb of dja...models.User
        return self.user.username