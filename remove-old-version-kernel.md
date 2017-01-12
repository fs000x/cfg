Open terminal and check your current kernel:

```
uname -r 
```

**DO NOT REMOVE THIS KERNEL!**

Next, type the command below to view/list all installed kernels on your system.

```
dpkg --list | grep linux-image 
```

Find all the kernels that lower than your current kernel. When you know which kernel to remove, continue below to remove it. Run the commands below to remove the kernel you selected.

```
sudo apt-get purge linux-image-x.x.x.x-generic 
```

Finally, run the commands below to update grub2

```
sudo update-grub2 
```

Reboot your system.
