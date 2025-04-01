# LuckPerms-GlobalPrefix

**LuckPerms-GlobalPrefix** retrieves a group's prefix meta tag and displays it in both TAB and global chat.

This plugin *should, in theory,* work with any tab list plugin.  
If it doesn't, feel free to open a GitHub issue! :)

> This plugin relies on the **MiniMessage format**, which is only supported on **Minecraft 1.16.5+** (due to AdventureAPI).  
> On older versions, color gradients **will not display correctly**.

### MiniMessage Generator
A great website to generate MiniMessage-formatted text is [RGB Birdflop](https://www.birdflop.com/resources/rgb/).  
Simply choose **Color Format > MiniMessage**.

---

## Requirements
- Minecraft **1.18.2+** server
- LuckPerms

> **Folia is not officially supported**, but it might work. Feel free to test it out!

---

## Future Goals
- [x] Display prefixes in chat
- [x] Display prefixes in TAB
- [ ] Add support for additional color formats
- [ ] Add support for suffixes *(insanely simple, just haven't had time yet)*
- [ ] Support custom join messages, including prefixes and/or suffixes  


---

## Setting Up LuckPerms Prefixes

### 1. Create a Group
Before assigning a prefix, you need to create a group. Use the following command:

`/lp creategroup GroupName`


### 2. Assign a Prefix
To add a prefix to the group, run:


`/lp group GroupName meta addprefix 100 "<Your gradient goes here>"`


#### What does this command do?
- `meta addprefix` creates a meta permission where the prefix is stored.
- `100` is the **weight** of the prefix (higher values take priority over lower ones).


### 3. Remove a Prefix
To remove a prefix from a group, use:

`/lp group default meta removeprefix 100`
Replace `100` with the actual weight value of the prefix you want to remove.


---

#### Note:
Contributions are always welcome! <3